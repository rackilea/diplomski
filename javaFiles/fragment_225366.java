package com.techventus;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;

import java.net.MalformedURLException;
import java.net.URL;

/*
// Necessary to help make correct calls to the API which does not apply and //URL special Character correction.
*/
public class CorrectGlideUrl extends GlideUrl
{
    String urlString;

    public CorrectGlideUrl(URL url)
    {
        super(url);
    }

    public CorrectGlideUrl(String url)
    {
        super(url);
        urlString = url;
    }

    public CorrectGlideUrl(URL url, Headers headers)
    {
        super(url, headers);
    }

    public CorrectGlideUrl(String url, Headers headers)
    {
        super(url, headers);
    }

    /**
     *
     * Returns a properly escaped {@link String} url that can be used to make http/https requests.
     *
     * @see #toURL()
     * @see #getCacheKey()
     */
    @Override
    public String toStringUrl() {

        return urlString.replace("%24","$");
//      return getSafeStringUrl();
    }


    /**
     * Returns a properly escaped {@link java.net.URL} that can be used to make http/https requests.
     *
     * @see #toStringUrl()
     * @see #getCacheKey()
     * @throws MalformedURLException
     */
    @Override
    public URL toURL() throws MalformedURLException {
        return getSafeUrl();
    }

    // See http://stackoverflow.com/questions/3286067/url-encoding-in-android. Although the answer using URI would work,
    // using it would require both decoding and encoding each string which is more complicated, slower and generates
    // more objects than the solution below. See also issue #133.
    private URL getSafeUrl() throws MalformedURLException {

        return null;
    }


}