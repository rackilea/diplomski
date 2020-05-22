SHDocVw.InternetExplorer ie = new SHDocVw.InternetExplorerClass();
IWebBrowserApp wb = (IWebBrowserApp) ie;
wb.Visible = true;
//Do anything else with the window here that you wish
wb.Navigate(url, ref o, ref o, ref o, ref o);
// add code to wait for navigation to complete... 
// i.e. by waiting for NavigateComplete2  event, or simply sleep...
wb.Document.cookie="....";