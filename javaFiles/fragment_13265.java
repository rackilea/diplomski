Uri.Builder builder = Uri.parse("http://sqlphptry.co.nf/createUser.php").buildUpon();
        builder.appendQueryParameter("teamName", "vcxvxcvcxvxcvxc");
        builder.appendQueryParameter("game", "COD: AW");
        builder.appendQueryParameter("consola", "Xbox One");

    String url = builder.build().toString();