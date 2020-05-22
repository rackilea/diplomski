<?php $form = ActiveForm::begin(
                [
                    'enableAjaxValidation' => true,
                    'validationUrl' => Url::toRoute('state/validation')
                ]
        ); ?>