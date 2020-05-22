@Override
        public byte[] getBody() {
            Map <String, String> params = new HashMap<>();
            params.put("Token", Sp.getInstance().ReadSP("_Token_"));
            params.put("Mobile", Sp.getInstance().ReadSP("_Phone_"));
            params.put("Fname", mName_edit_profile.getText().toString());
            params.put("Lname", mName_edit_profile.getText().toString());
            params.put("Email", mEmail_edit_profile.getText().toString().trim());
            aEncodedImage = getStringImage(((BitmapDrawable) mImage_profile.getDrawable()).getBitmap());
            params.put("Pic", aEncodedImage);

            ..... (Write the below code here)

            return params;
        }