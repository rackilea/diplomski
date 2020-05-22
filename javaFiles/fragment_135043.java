if (mAnswerLocationByQuestionLocation.indexOfKey(questionLocation) > -1)
    {
        MyModel model = (MyModel)mAnswerList.getItemAtPosition(questionLocation);
    model.isSelected= true;
    answerAdapter.notifyDataSetChanged();

    }
}