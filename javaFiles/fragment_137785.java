shopNameTemp = node.first().select("a[class=fn]").text();
shopAddressTempA = node.first().select("span[class=street-address]").text();
shopAddressTempB = node.first().select("span[class=locality]").text();
shopAddressTempC = node.first().select("span[class=region]").text();
shopAddressTempD = node.first().select("span[class=postal-code]").text();
shopTelTemp = node.first().select("div[class=call phone-number]").text();