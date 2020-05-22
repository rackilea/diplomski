public function rules()
 {
    return [
        ['state', 'required', 'targetClass' => '\backend\models\State', 
        'message' => 'Your message here'],
    ];
 }