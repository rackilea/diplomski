abstract class ModalWindowModel
{
  protected ModalWindowModel modalWindowModel; //This can be any class implementing/derived from ModalWindowModel
}

class SimpleModalWindowModel extends ModalWindowModel
{
 SimpleModalWindowModel(ModalWindowModel modalWindowModel)
 {
  this.modalWindowModel = modalWindowModel;
 }


 // your other code goes here
}

class FancyModalWindowModel extends ModalWindowModel
{
 FancyModalWindowModel(ModalWindowModel modalWindowModel)
 {
  this.modalWindowModel = modalWindowModel;
 }

 // your other code goes here
}

...
// Usage
ModalWindowModel simpleModalWindowModel = new SimpleModalWindowModel(null);
ModalWindowModel fancyModalWindowModel = new FancyModalWindowModel(simpleModalWindowModel);
....