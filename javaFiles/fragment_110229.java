import yourPackage.MobileStorage;
        import yourPackage. MobileMessage;

        public class test{

        @BeforeTest
        public void  prepareInstance(){

            MobileStorage mobStg = new MobileStorage();
            MobileMessage mobMsg = new MobileMessage();
        }

        //test simple msg
        @Test
        public void  testSave(){

          mobStg.saveMessage("hello")
          assert.assertEquals("hello", mobMsg.getText())
        }

        //test msg with more chars
        @Test
        public void  testMsgMoreChar(){
             mobStg.saveMessage("messageWithMoreThan160Char")

             //access messagepart here somehow, i am not sure of that
              assert.assertEquals(mobMsg.getText(), mobStg.messagePart);

             //access message here somehow. This will test listMessages() and concatenation of msgs
             assert.assertEquals(mobStg.message, mobStg.listMessages())   
        }

 //test deletion of msg   
@Test    
public void  testDelete(){
             mobStg.deleteMessage();
              assert.assertEquals(null, mobMsg.getPredecessor()) 
        }



    }