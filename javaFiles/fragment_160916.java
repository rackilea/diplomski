% create java image
I = imread('office_3.jpg');
javaImage = im2java(I);

% get image properties
H=javaImage.getHeight;
W=javaImage.getWidth;

% repackage as a 3D array (MATLAB image format)
B = uint8(zeros([H,W,3]));
pixelsData = uint8(javaImage.getBufferedImage.getData.getPixels(0,0,W,H,[]));
for i = 1 : H
base = (i-1)*W*3+1;
B(i,1:W,:) = deal(reshape(pixelsData(base:(base+3*W-1)),3,W)');
end

% display image
imshow(B);