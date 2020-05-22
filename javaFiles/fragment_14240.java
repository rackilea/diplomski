public void onTextChanged(CharSequence s, int start,
int before, int count)
{

    textlength = edittext.getText().length();
    text_sort.clear();
    image_sort.clear();

    for (int i = 0; i < text.length; i++)
    {
        if (textlength <= text[i].length())
        {
            if (edittext.getText().toString().
                    equalsIgnoreCase((String) text[i].subSequence(0, textlength)))
            {
                text_sort.add(text[i]);
                image_sort.add(image[i]);
            }
        }
    }

    listview.setAdapter(new MyCustomAdapter(text_sort, image_sort));

    }
}