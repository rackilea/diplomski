@Override
public void onResponse(Response<TranslatedData> response, Retrofit retrofit) {
    String output = String.format(response.body().responseData.translatedText);
    String.format("Translation of: %s, %s->%s = %s", textToTranslate, fromLanguage, toLanguage, response.body().responseData.translatedText);
    System.out.println("Result: " + output);
    translation = output;
    System.out.println("The result of the field translation is: " + translation);

    //this is the line you would add...
    listener.onTranslateReceived(translation);
}