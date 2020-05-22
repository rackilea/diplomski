package com.github.davidepastore.stackoverflow38768839;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;

/**
 * Stackoverflow 38768839 answer.
 *
 */
public class App {

    private static final String COOKIE_NAME = "JSESSIONID";

    public static void main(String[] args) throws IOException {
        // Step 1 - Get the cookie
        String homeURL = "https://www.studenti.ict.uniba.it/esse3/Home.do";
        Response response = Jsoup.connect(homeURL).execute();
        String jsessionid = response.cookie(COOKIE_NAME);
        System.out.println(COOKIE_NAME + " cookie: " + jsessionid);

        // Step 2 - Try to login
        String strURL = "https://www.studenti.ict.uniba.it/esse3/auth/Logon.do";
        String strUserId = "prova";
        String strPasword = "prova";

        String authString = strUserId + ":" + strPasword;

        String encodedString = new String(Base64.encodeBase64(authString
                .getBytes()));

        try {

            response = Jsoup.connect(strURL)
                    .header("Authorization", "Basic " + encodedString)
                    .cookie(COOKIE_NAME, jsessionid)
                    .method(org.jsoup.Connection.Method.GET).timeout(30000)
                    .execute();

            System.out.println(response.parse());

            System.out.println("Autenticato");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}