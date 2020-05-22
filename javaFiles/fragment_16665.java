function checkArticle(selectedArticleId) {
    var url = 'myController?id=' + selectedArticleId.value;
    xmlHttpObject.open('GET', url);
    xmlHttpObject.onreadystatechange = handleStateChange;
    xmlHttpObject.send();
}