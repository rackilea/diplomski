try {
            if (SDK_INT >= 10) {
                ThreadPolicy tp = ThreadPolicy.LAX;
                StrictMode.setThreadPolicy(tp);
            }
            Document doc = Jsoup
                    .parse("<span style=\"display:none\"><menu type='ServerMenu' id=\"zz18_ViewSelectorMenu\" CompactMode=\"true\"><ie:menuitem id=\"zz19_DefaultView\" type=\"option\" onMenuClick=\"window.location = '/etudes/Portal/edt/Lists/Promo 2015/1A.aspx';\" text=\"1A\" menuGroupId=\"100\"></ie:menuitem>");
            String requiredaspxpage = doc.select("menu#zz18_ViewSelectorMenu")
                    .get(0).children().get(0).attr("onMenuClick");
        } catch (Exception ex) {
            ex.printStackTrace();
        }