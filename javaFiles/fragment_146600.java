myNoneEmptyEdittextCounter = 0;
for (int i=1;i<=no;i++)
{
    myEt = (EditText) findViewById(i);
    if(!TextUtils.isEmpty(myEt.getText().toString()))
    {
        myNoneEmptyEdittextCounter +=1;
    }
}
//myNoneEmptyEdittextCounter is count of your filled edittexts