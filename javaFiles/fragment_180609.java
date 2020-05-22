package com.example.alex.finalproject;

import java.net.URLEncoder;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Query;

class TranslatedData {
    ResponseData responseData;
}

class ResponseData {
    String translatedText;
}

public class TranslateAPI {
    private static final String ENDPOINT = "http://api.mymemory.translated.net";
    public final static String SPANISH = "ES";
    public final static String ENGLISH = "EN";


    private final TranslateService mService;

    public interface TranslateService {
        @GET("/get")
        Call<TranslatedData> getTranslation(
            @Query("q") String textToTranslate,
            @Query(value = "langpair", encoded = true)
        String languagePair);
    }

    public TranslateAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(TranslateService.class);
    }

    public void translate(final String textToTranslate, final String fromLanguage, final String toLanguage) {
        mService.getTranslation(textToTranslate, URLEncoder.encode(fromLanguage + "|" + toLanguage))
            .enqueue(new Callback<TranslatedData>() {

                @Override
                public void onResponse(Response<TranslatedData> response, Retrofit retrofit) {
                    String output =
                        String.format("Translation of: %s, %s->%s = %s", textToTranslate,
                            fromLanguage, toLanguage, response.body().responseData.translatedText);

                    System.out.println("Result: " + output);
                }

                @Override public void onFailure(Throwable t) {
                    System.out.println("[DEBUG]" + " RestApi onFailure - " + "");
                }
            });
    }
}