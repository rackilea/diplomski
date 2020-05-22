String text = "Hello Mister James! Do you use trello fregiently? "
        + "Do you know Canelo Pavelo magenta ravelo sagenta! "
        + "lolita kalola lalilo lalita 333l lo.";

String word = "232";

System.out.println(text.replaceAll("(\\w+lo\\b)", "$1 " + word));