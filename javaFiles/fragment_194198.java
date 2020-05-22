StringBuilder sb = new StringBuilder();
sb.append("select contactName , phone1 from tbl_dealer where 1=1 ");
appendFilter(sb, "districtID", districtID);
appendFilter(sb, "stateID", stateID);
appendFilter(sb, "talukaID", talukaID);
final String query=sb.toString();