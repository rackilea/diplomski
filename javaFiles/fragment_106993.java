package domainmodel;

import java.beans.PropertyEditorSupport;

public class DeveloperEditor extends PropertyEditorSupport {

    private GameOrganizer gameOrganizer;


    public void setGameOrganizer(GameOrganizer gameOrganizer) {
        this.gameOrganizer = gameOrganizer;
    }

    @Override
    public void setAsText(String id) {
        long id2 = Long.parseLong(id);
        Developer type = gameOrganizer.getDeveloper(id2);
        setValue(type);
    }
}