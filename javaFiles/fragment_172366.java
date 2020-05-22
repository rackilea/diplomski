Log.e("listOfElements", listOfElements);
            //refactoring html
            listOfElements = wrapImgWithCenter(listOfElements);
            // Put new value in htmlContent
            postObject.put("htmlContent", listOfElements);

        } else {
            //refactoring html
            webText = wrapImgWithCenter(webText);
            postObject.put("htmlContent", webText);
        }