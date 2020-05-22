public class Deatails {

private String title;
private List<UrlAttachments> attachments;

public String getTitle() {

    return title;
}

public List<UrlAttachment> getAttachment(){
    return attachments;
}

public void setAttachment(List<UrlAttachment> list){
    this.attachments = list;
}
}