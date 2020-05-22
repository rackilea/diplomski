String s = "POST /fr.synomia.search.ws.module.ModuleSearch/geResults/jsonp?xmlQuery=<?xml version='1.0' encoding='UTF-8'?><query ids=\"16914\"><matchWord>avoir</matchWord><fullText><![CDATA[]]></fullText><quotedText><![CDATA[]]></quotedText><sensitivity></sensitivity><operator>AND</operator><offsetCooc>0</offsetCooc><cooc></cooc><collection>0</collection><searchOn>all</searchOn><nbResultDisplay>10</nbResultDisplay><nbResultatsParAspect>5</nbResultatsParAspect><nbCoocDisplay>8</nbCoocDisplay><offsetDisplay>0</offsetDisplay><sortBy>date</sortBy><dateAfter>0</dateAfter><dateBefore>0</dateBefore><ipClient>82.122.169.244</ipClient><typeQuery>0</typeQuery><equivToDelete></equivToDelete><allCooc>false</allCooc><versionDTD>3.0.5</versionDTD><r34>1tcbet30]</r34><mi>IND</mi></query>&callback=__gwt_jsonp__.P1.onSuccess&failureCallback=__gwt_jsonp__.P1.onFailure HTTP/1.1";
Pattern p = Pattern.compile(
            "<\\?xml version='1.0' encoding='[^']+'\\?><query ids=\"([0-9]+)\"><matchWord>.*");

Matcher m = p.matcher(s);

if (m.find()) {
    System.out.println("Group: "+m.group(1));
}