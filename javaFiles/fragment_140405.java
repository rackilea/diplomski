Object inputObject = sInput.readObject();     // Read the object once
if (inputObject instanceof Message) {         // If the object is a message
  Message m = (Message) inputObject;          //   cast as a Message
  ...                                         //   use the Message m
} else if (inputObject instanceof File) {     // else if it's a file
  File f = (File) inputObject;                //   cast as a File
  ...                                         //   use the File f
}