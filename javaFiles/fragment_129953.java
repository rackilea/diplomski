Taking a example to show the name of the workflow initiator 

1) /libs/cq/workflow/content/notifications/workitemdetails/items/content/items/itemdetails/items/well/items
create a new node : nt:unstructured
(ex)
fieldLabel - String - Started By
name - String - startedBy
renderReadOnly - Boolean - true
showEmptyInReadOnly - Boolean - true
sling:resourceType - String - granite/ui/components/foundation/form/textfield

2) /libs/cq/workflow/components/inbox/list/json.jsp
add code :

WorkflowStatus wfStatus = res.adaptTo(WorkflowStatus.class);                
if (wfStatus != null) {
   List<Workflow> workflows = wfStatus.getWorkflows(true);
   if(workflows.size() > 0) {
     String initiator = workflows.get(0).getInitiator();
     writer.key("startedBy").value(initiator);
   }
}

Note :
key name (startedBy) should match the name defined in new node

3) /libs/cq/workflow/gui/components/inbox/clientlibs/inbox/js/model/InboxItemModel.js
toJSON: function() {
.
.
.
startedBy: Granite.I18n.getVar(this.get("startedBy")) || "",
}

Now you can see the custom node entry in /notifications.html]

screen shot :
https://i.stack.imgur.com/YpoY9.png