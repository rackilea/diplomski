public void onClick(View v) {           
                    menuKey = 0;
                    Varialbes.menuNewsMap.clear();                            
                    menuLink = "http://www.aaa.org/rss/rssblog";
                    RssParser pareser= new RssParser();
                    menuItems = pareser.getNewsList(menuLink);                  
                    Varialbes.menuNewsMap.put(menuKey, menuItems);              
                Intent intent = new Intent(MainNewsActivity.this,MenuNewsActivity.class);       

                intent.putExtra(Varialbes.PAPER, paper);
                intent.putExtra(Varialbes.MENU_TITLE, "Column");
                intent.putExtra(Varialbes.MENU_KEY, menuKey);
                startActivity(intent);

            }