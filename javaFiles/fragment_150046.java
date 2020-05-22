function scan() {
......
.....
dynamicWebTwain1.AcquireImage(); //this method is non-blocking
             dynamicWebTwain1.attachEvent('OnPostAllTransfers',dynamicWebTwain1_OnPostAllTransfers);

}
function dynamicWebTwain1_OnPostAllTransfers(){
........
...........
strActionPage += "&AttachmentCode="+attachmentCode+"&AttachmentDesc="+attachmentDesc+"&AttachmentDetail="+attachmentDetail+"&FileType="+fileType+"&FileName="+fileName;
dynamicWebTwain1.HTTPUploadAllThroughPostAsPDF(document.location.hostname, strActionPage, fileName);
zAu.send(new zk.Event(zk.Widget.$('$btnScan'), 'onScan', null, {toServer:true}));
}