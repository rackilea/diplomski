public class ProcessAction extends DispatchAction {

    String dupValue = null;
    ArrayList<String> dupList = new ArrayList<String>();

    private String validateDuplicateRecords(ProcessForm process) {
        String errorMessage = null;

        dupValue = process.getId.trim()+"    "+process.getFirstname().trim()+"    "+process.getLastanme().trim();
        mLogger.debug("order id,ctn,item id: "+dupValue);
        if (dupList.contains(dupValue)){
            mLogger.debug("value not added");
            errorMessage = "Duplicate Record Exists";
        } else {
            dupList.add(dupValue);
        }

        return errorMessage;
    }
}