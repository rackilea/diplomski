@XmlSchema(
    xmlns = { 
        @XmlNs(prefix = "video", namespaceURI = "http://www.google.com/schemas/sitemap-video/1.1"),
        @XmlNs(prefix = "", namespaceURI = "http://www.sitemaps.org/schemas/sitemap/0.9")
    }
)

/*
 * xmlns="http://www.sitemaps.org/schemas/sitemap/0.9"
 * xmlns:video="http://www.google.com/schemas/sitemap-video/1.1"
 */

package com.example.myapplication.model.sitemap.pojo;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;