function encodeLatin1URIComponent(str) {
    var bytes= '';
    for (var i= 0; i<str.length; i++)
        bytes+= str.charCodeAt(i)<256? str.charAt(i) : '?';
    return escape(bytes).split('+').join('%2B');
}