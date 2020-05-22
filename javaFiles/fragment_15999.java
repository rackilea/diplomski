function extractGuid(value) {
    var re = /[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}/i;
    var match = re.exec(value);
    return match ? match[0] : null;
}

var guid = extractGuid(window.location.href);