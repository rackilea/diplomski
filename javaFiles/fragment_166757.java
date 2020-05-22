<activiti:taskListener event="complete" class="org.alfresco.repo.workflow.activiti.tasklistener.ScriptTaskListener">
          <activiti:field name="script">
             <activiti:string> 
                for (var i = 0; i &lt; bpm_package.children.length; i++){
                 var p = bpm_package;
                 var doc = p.children[i];
                 var myNode = initiatorhome.childByNamePath("foldertomove/testFolder"); <!-- the names of the nodes under the root directory where the file should be moved to-->
                 doc.move(myNode); 
                }
             </activiti:string>
          </activiti:field>
       </activiti:taskListener>