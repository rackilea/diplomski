import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
serCam = InitUSBcamera;  % initialize USB camera as a serial port
type = java.lang.String('jpg'); % translating matlab to java 
outputStream = ByteArrayOutputStream; % create java output stream
im = getsnapshot(serCam);  % get an image from the camera
im2 = imresize(im, [96,128],'nearest');  % reduce the size 
im3 = im2java2d(im2); % create java Buffered Image
ImageIO.write(im3, type, outputStream);
bytes = outputStream.toByteArray();
fwrite(serTablet, bytes, 'int8') % send the image // changed to async