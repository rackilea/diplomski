for (Rect rect : facesArray) {
            Imgproc.rectangle(frame, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                    new Scalar(0, 255, 0)); // frame is Mat
            rectCrop = new Rect(rect.x, rect.y, rect.width, rect.height);

            Mat image_roi = new Mat(frame,rectCrop);
             Imgcodecs.imwrite("./face"+ i +".jpg",image_roi);
             i++;
        }