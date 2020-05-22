try
        {
            List<IWebBrowser2> browsers = getIWebBrowser2();
            for(IWebBrowser2 browser : browsers){
                if(browser.visible())
                {

                    IShellFolderViewDual3 view = getIShellFolderViewDual3(browser);
                    if (view != null && browser.visible()) {

                        FolderItems items = view.selectedItems();

                        for (Com4jObject object : items) {
                            FolderItem item = object.queryInterface(FolderItem.class);
                            if (item != null) {
                                newResults+=item.path()+" - "+item.type()+"\n\n";
                            }
                        }
                    }
                }
            }
        }