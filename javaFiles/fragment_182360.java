public InputStream giveItToMe() {
   ...
}


from("bean:myBean?method=giveItToMe")
  .to("stream:out");