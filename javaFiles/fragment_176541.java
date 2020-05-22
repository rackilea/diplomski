String s = "Doc201810011052053_fotoAssicurazioneCartaceo_3962128_943000.jpg";
Pattern rexExp = Pattern.compile("_(\\w+)_\\d+_\\d+\\.[^.]*$");
Matcher matcher = rexExp.matcher(s);
if (matcher.find()){
    System.out.println(matcher.group(1)); 
} // => fotoAssicurazioneCartaceo