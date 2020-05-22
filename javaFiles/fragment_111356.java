import cv2
import numpy as np
image = cv2.imread("D:\\Users\\Downloads\\CaptureMultiLines.jpg")
cv2.imshow('orig',image)
# image = cv2.resize(image_original,None,fx=4, fy=4, interpolation = cv2.INTER_CUBIC)

#grayscale
gray = cv2.cvtColor(image,cv2.COLOR_BGR2GRAY)
# original_resized = cv2.resize(gray, (0,0), fx=.2, fy=.2)
cv2.imshow('gray',gray)
cv2.waitKey(0)

#Remove Salt and pepper noise
saltpep = cv2.fastNlMeansDenoising(gray,None,9,13)
# original_resized = cv2.resize(saltpep, (0,0), fx=.2, fy=.2)
cv2.imshow('Grayscale',saltpep)
cv2.waitKey(0)

#blur
blured = cv2.blur(saltpep,(3,3))
# original_resized = cv2.resize(blured, (0,0), fx=.2, fy=.2)
cv2.imshow('blured',blured)
cv2.waitKey(0)

#binary
ret,thresh = cv2.threshold(gray,127,255,cv2.THRESH_BINARY_INV)
# original_resized = cv2.resize(thresh, (0,0), fx=.2, fy=.2)
cv2.imshow('Threshold',thresh)
cv2.waitKey(0)

#dilation
kernel = np.ones((5,100), np.uint8)
img_dilation = cv2.dilate(thresh, kernel, iterations=1)
# original_resized = cv2.resize(img_dilation, (0,0), fx=.2, fy=.2)
cv2.imshow('dilated',img_dilation)
cv2.waitKey(0)

#find contours
im2,ctrs, hier = cv2.findContours(img_dilation.copy(), cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

#sort contours
sorted_ctrs = sorted(ctrs, key=lambda ctr: cv2.boundingRect(ctr)[1])

for i, ctr in enumerate(sorted_ctrs):

    # Get bounding box
    x, y, w, h = cv2.boundingRect(ctr)

    # Getting ROI
    roi = image[y:y+h, x:x+w]

# #   show ROI
    cv2.imshow('segment no:' +str(i),roi)
    cv2.waitKey(0)


    im = cv2.resize(roi,None,fx=4, fy=4, interpolation = cv2.INTER_CUBIC)
    ret_1,thresh_1 = cv2.threshold(im,127,255,cv2.THRESH_BINARY_INV)
    # original_resized = cv2.resize(thresh, (0,0), fx=.2, fy=.2)
    cv2.imshow('Threshold_1',thresh_1)
    cv2.waitKey(0)
    thresh_1=cv2.cvtColor(thresh_1, cv2.COLOR_BGR2GRAY);

    #find contours
    im,ctrs_1, hier = cv2.findContours(thresh_1, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    #sort contours
    sorted_ctrs_1 = sorted(ctrs_1, key=lambda ctr: cv2.boundingRect(ctr)[0])

    for j, ctr_1 in enumerate(sorted_ctrs_1):

        # Get bounding box
        x_1, y_1, w_1, h_1 = cv2.boundingRect(ctr_1)

        # Getting ROI
        roi_1 = thresh_1[y_1:y_1+h_1, x_1:x_1+w_1]

        # #   show ROI
        cv2.imshow('Line no: ' + str(i) + "Column no : " +str(j),roi_1)
        cv2.waitKey(0)


# original_resized = cv2.resize(image, (0,0), fx=.2, fy=.2)
# cv2.imshow('marked areas',original_resized)
cv2.imshow('marked areas',image)
cv2.waitKey(0)