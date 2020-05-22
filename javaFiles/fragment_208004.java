public class LogicalNode
    {
        private List<LogicalNode> _inputs = new List<LogicalNode>();
        private String _name = "Not Set";


        public override string ToString()
        {
            return String.Format("Node {0}", _name);
        }

        public void Reset()
        {
            _inputs.Clear();
        }

        public void SetName(String name)
        {
            _name = name;
        }

        protected List<LogicalNode> GetInputs()
        {
            return _inputs;
        }

        public void AddInput(LogicalNode node)
        {
            _inputs.Add(node);
        }

        protected virtual bool ComputeOutputInternal()
        {
            return false;
        }

        public bool ComputeOutput()
        {
           // Console.WriteLine("Computing output on {0}.", _name);
            return ComputeOutputInternal();
        }
    }

    public class LogicalInput : LogicalNode
    {
        private bool _state = true;

        public void SetState(bool state)
        {
            _state = state;
        }

        public bool GetState() { return _state; }

        protected override bool ComputeOutputInternal()
        {
            return _state;
        }
    }

    public class LogicalAND : LogicalNode
    {
        protected override bool ComputeOutputInternal()
        {
            List<LogicalNode> inputs = GetInputs();
            bool result = true;
            for (Int32 idx = 0; idx < inputs.Count && result; idx++)
            {
                result = result && inputs[idx].ComputeOutput();
            }
            return result;
        }
    }

    public class LogicalOR : LogicalNode
    {
        protected override bool ComputeOutputInternal()
        {
            List<LogicalNode> inputs = GetInputs();
            bool result = false;
            for (Int32 idx = 0; idx < inputs.Count; idx++)
            {
                result = inputs[idx].ComputeOutput();
                if (result)
                    // If we get one true, that is enough.
                    break;
            }
            return result;
        }
    }

    public class LogicalNOT : LogicalNode
    {
        protected override bool ComputeOutputInternal()
        {
            List<LogicalNode> inputs = GetInputs();
            if (inputs.Count > 0)
            {   // NOTE:  This is not an optimal design for
                // handling distinct different kinds of circuits.
                //
                // It it demonstrative only!!!!
                return !inputs[0].ComputeOutput();
            }
            return false;
        }