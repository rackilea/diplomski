...
            if (argument != null) {
                conf.set("mapred.max.split.size", argument);
            } else {
                conf.set("mapred.max.split.size", "134217728"); // 128 MB
            }
...

            conf.setInputFormat(CombinedInputFormat.class);
...