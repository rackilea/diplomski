PDDocument watermarkDoc = PDDocument.load("watermark.pdf");
//Assuming your empty document with watermark image in it.

PDDocument realDoc = PDDocument.load("document-to-be-watermarked.pdf");
//Let's say this is your document that you want to watermark. For example sake, I am opening a new one, you would already have a reference to PDDocument if you are creating one

Overlay overlay = new Overlay();
overlay.overlay(realDoc,watermarkDoc);
watermarkDoc.save("document-now-watermarked.pdf");