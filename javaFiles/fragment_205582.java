use(function() {
    var pageLang = currentPage.properties.get("jcr:language", "en");
    var otherLangText; 
    var currPage = currentPage.name;
    var currPagePath = currentPage.path;
    var goPage; 

    if (pageLang == "fr_ca") { 
        otherLangText = "English";
        goPage = currPagePath+"/profile.html";
    } else { 
        otherLangText = "Français"; 
        goPage = currPagePath+"/profile.html"; 
    };


    return {
        otherLanguage: otherLangText, 
        goToPage: goPage
    }


})