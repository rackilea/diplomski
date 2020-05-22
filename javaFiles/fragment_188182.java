buildTypes {

    debug {
      buildConfigField("String", "API_URL", "<dev_url>")
    }

    qa {
      buildConfigField("String", "API_URL", "<qa_url>")
    }

    release {
      buildConfigField("String", "API_URL", "<prod_url>")
    }
}