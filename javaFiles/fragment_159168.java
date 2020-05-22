private String id; //its setter getters
________________________________________________________________________________

//clear method
public void clearMaster()
{
 try
 {
    if(id!=null && id.equals("1"))
    {
     byRfq="";
     byNsn="";
     byDoc="";
     byLetterNo="";
     byLetterDate=null;
     byEmailDate=null;      
    }
  }catch(Exception ee){}
}
________________________________________________________________________________

//write inside the method which is calling default on master
try{
 int id = Integer.valueOf(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
 this.id=id+"";      
}catch(Exception ee){}
id="";
________________________________________________________________________________
inside UI JSF VIEW of screen
<f:view >
<f:metadata>
<f:viewParam name="id" value="#{letterCancellationManager.id}" />
<f:event type="preRenderView" listener="#{letterCancellationManager.clearMaster}"/>     
</f:metadata>