public function actionValidation(){
    $model = new State();
    if(Yii::$app->request->isAjax && $model->load(Yii::$app->
    request->post())){
        Yii::$app->response->format = 'json';
        return ActiveForm::validate($model);
    }     
}