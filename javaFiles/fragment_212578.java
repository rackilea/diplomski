else //It's perhaps a page on the help toppic
{
//Serach the page from  
int ind = url.lastIndexOf('!');
url = url.substring(ind+1,url.length());
url = url.replaceFirst(MainFrame.helpPath+"/","");
updatePage(getLinkedPage(pageRoot.children(), url), true);
}