String tag = "[";
tag += this.getClass().toString();
tag += " :: ";
tag += Thread.currentThread().getStackTrace()[1].getMethodName().toString();
tag += "]";
Log.i(tag, "Message");