[StatelessScriptUpdateProcessorFactory]

function processAdd(cmd) {
    doc = cmd.solrDoc;
    multiDate = doc.getFieldValue("multiValueField");
    //Apply your operation to above field
    //doc.setField("multiValueField",value);

}
function processDelete(cmd) {
  // no-op
}

function processMergeIndexes(cmd) {
  // no-op
}

function processCommit(cmd) {
  // no-op
}

function processRollback(cmd) {
  // no-op
}

function finish() {
  // no-op
}