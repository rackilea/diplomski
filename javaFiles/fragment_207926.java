package org.bamboomy.cjr.dao.factcode;

import org.bamboomy.cjr.dto.FactCodeDto;

import java.util.Date;
import java.util.List;

/**
 * Created by a162299 on 3-11-2015.
 */
public class FactCodeDtoResultTransformer implements org.hibernate.transform.ResultTransformer {

    @Override
    public Object transformTuple(Object[] objects, String[] strings) {

        FactCodeDto result = new FactCodeDto();

        for (int i = 0; i < objects.length; i++) {
            setField(result, strings[i], objects[i]);
        }

        return result;
    }

    private void setField(FactCodeDto result, String string, Object object) {

        if (string.equalsIgnoreCase("cdFact")) {
            result.setCdFact((String) object);
        } else if (string.equalsIgnoreCase("cdFactSuffix")) {
            result.setCdFactSuffix((String) object);
        } else if (string.equalsIgnoreCase("isSupplementCode")) {
            result.setIsSupplementCode((Boolean) object);
        } else if (string.equalsIgnoreCase("isTitleCode")) {
            result.setIsTitleCode((Boolean) object);
        } else if (string.equalsIgnoreCase("mustBeFollowed")) {
            result.setMustBeFollowed((Boolean) object);
        } else if (string.equalsIgnoreCase("activeFrom")) {
            result.setActiveFrom((Date) object);
        } else if (string.equalsIgnoreCase("activeTo")) {
            result.setActiveTo((Date) object);
        } else if (string.equalsIgnoreCase("descFr")) {
            result.setDescFr((String) object);
        } else if (string.equalsIgnoreCase("descNl")) {
            result.setDescNl((String) object);
        } else if (string.equalsIgnoreCase("descDe")) {
            result.setDescDe((String) object);
        } else if (string.equalsIgnoreCase("type")) {
            result.setType((String) object);
        } else if (string.equalsIgnoreCase("idFact")) {
            result.setIdFact((Long) object);
        } else if (string.equalsIgnoreCase("idParent")) {
            result.setIdParent((Long) object);
        } else if (string.equalsIgnoreCase("isCode")) {
            result.setIsCode((Boolean) object);
        } else {
            throw new RuntimeException("unknown field");
        }

    }

    @Override
    public List transformList(List list) {
        return list;
    }
}