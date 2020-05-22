IInfoObjects oParents = infoStore.query("select si_id from ci_infoobjects where si_kind = 'folder' and si_name = '" + temp + "'");
if(oParents.size()==0)
    return; // folder name not found

IInfoObject oParent = (IInfoObject)oParents.get(0);

String query = "select SI_NAME, SI_ID from CI_INFOOBJECTS "
        + "where SI_KIND = 'Webi' and si_parentid = " + oParent.getID();