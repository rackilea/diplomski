package de.scrum_master.aspect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import de.scrum_master.app.Application;
import de.scrum_master.app.Entity;

public aspect EntityCaptionLocaliser {
    public interface LocalisedCaption {
        String getCaption(String attributeName);
    }

    declare parents :
        @Entity * implements LocalisedCaption;

    public String LocalisedCaption.getCaption(String attributeName)
        throws ReflectiveOperationException
    {
        String fieldName = attributeName + Application.locale;
        Field field = getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (String) field.get(this);
    }

    public Map<String, String> LocalisedCaption.getAllCaptions()
            throws ReflectiveOperationException
        {
            Map<String, String> captions = new HashMap<>();
            for (Field field : getClass().getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()))
                    continue;
                String attributeName = field.getName();
                captions.put(attributeName, getCaption(attributeName));
            }
            return captions;
        }

    public Map<String, Object> LocalisedCaption.getCaptionValuePairs()
            throws ReflectiveOperationException
        {
            Map<String, Object> captions = new HashMap<>();
            for (Field field : getClass().getDeclaredFields()) {
                if (Modifier.isStatic(field.getModifiers()))
                    continue;
                field.setAccessible(true);
                String attributeName = field.getName();
                captions.put(getCaption(attributeName), field.get(this));
            }
            return captions;
        }
}