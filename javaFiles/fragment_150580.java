EasyMock.expect(ContentChanger.change( var )).andAnswer(new IAnswer<Integer>() {
        @Override
        public Integer answer() throws Throwable {
            StringBuffer sb = (StringBuffer) EasyMock.getCurrentArguments()[0];
            sb.append( "Mocked" );
            return 1;
        }
    })