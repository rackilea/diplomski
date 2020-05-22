String str = "<a href=\"http://rdmobile.fr/blog/mobile-la-pub-consomme-plus-que-les-applications-elles-memes/\"><img align=\"left\" hspace=\"5\" width=\"150\" height=\"150\" src=\"http://rdmobile.fr/blog/wp-content/uploads/2012/03/angry-birds-150x150.jpg\" class=\"alignleft tfe wp-post-image\" alt=\"angry-birds\" title=\"angry-birds\" /></a>Si vous aussi vous vous étonnez de voir votre batterie fondre comme neige au soleil dès lors que jouez à Angry Birds, rassurez-vous, c’est normal. Des chercheurs de l&#8217;université de Purdue se sont intéressés aux publicités destinées majoritairement aux applications gratuites, et oui, comment les développeurs mangent-ils autrement ? Plus sérieusement, cette étude, publiée sur le [...]";        
Matcher m = Pattern.compile(" (?:href|src)=\"([^\"]+)").matcher(str);

while (m.find()) {
    System.out.println(m.group(1));
}