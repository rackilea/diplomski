array(
'class'=>'CButtonColumn',
'template'=>'{email}',
'buttons'=>array
(   'email' => array
    (
        'label'=>'Send an e-mail to this user',
        'click'=>'function(){
          return confirm("Are you sure to send mail to this user?");

        }',
        'url'=>'Yii::app()->createUrl("todoList/sendEmail", array("id"=>$data->userId))',
    ),
),